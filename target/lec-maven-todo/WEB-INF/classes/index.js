function xhr_func (method, url, data=null, callback) {
    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function() {
        if (xhr.readyState === xhr.DONE) {
            if (xhr.status === 200 || xhr.status === 201) {
                let results = JSON.parse( xhr.responseText );
                callback(results);
            } else {
                console.error(xhr.responseText);
            }
        }
    };
    xhr.open(method, url);
    xhr.send(data);
}

function render_empty_li (data) {
    let types = ['todo', 'doing', 'done'];
    types.forEach((el) => {
        if ( data.map((v)=> v.type ).indexOf(el) < 0 ) new Item().noData(el);
    });
}

AJAX = function(){
    this.get = function (url, callback){
        xhr_func('GET', url, null, callback);
    }
}

Item = function(data){
    this.data = data;
    this.tpl = `
        <h3>{%title%}</h3>
        <div>
            <span>{%regdate%}</span>
            <span>{%name%}</span>
            <span>{%sequence%}</span>
        </div>
    `;
    this.render = function(){
        this.tpl = this.tpl.replace('{%title%}', this.data.title);

        let created_at = this.data.regDate.year + "/" + this.data.regDate.monthValue + "/" + this.data.regDate.dayOfMonth;
        this.tpl = this.tpl.replace('{%regdate%}', created_at);

        this.tpl = this.tpl.replace('{%name%}', this.data.name);
        this.tpl = this.tpl.replace('{%sequence%}', this.data.sequence);

        let li = document.createElement("li");
        li.innerHTML = this.tpl;

        li.setAttribute("class", "todo-item");
        li.setAttribute("data-id", this.data.id);

        if( this.data.type != 'done'){
            let nextBtn = document.createElement("button");
            nextBtn.textContent = "\>";
            li.children[1].append(nextBtn);
        }

        let ul = document.querySelector(`.${this.data.type} ul`);
        ul.append(li);
    }
    this.noData = function(className = 'todo'){
        let li = document.createElement("li");
        li.innerHTML = "there's no data yet";
        let ul = document.querySelector(`.${className} ul`);
        ul.append(li);
    }
}

let ajax = new AJAX();
let allTodos = ajax.get("/api/v1/todos", getAllTodos);

function getAllTodos (data) {
    render_empty_li(data);

    if( data.length ) {
        console.log(data);
        data.forEach((v, i)=>{
            let item = new Item(v);
            item.render();
        });
        allTodos = data;
        return data;
    }
}

document.querySelector('header button').addEventListener('click', function(e){
    document.querySelector("#input-modal").style.display = "unset";
});
document.querySelector('#input-modal .btns #cancel').addEventListener('click', function(e){
    e.preventDefault();
    document.querySelector("#input-modal").style.display = "none";
});



