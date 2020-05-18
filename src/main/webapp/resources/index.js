const modal = document.querySelector('#input-modal');

function xhr_func (method, url, data=null, callback) {
    let xhr = new XMLHttpRequest();
    // let formData = null;
    let formData = [];
    if( data ){
        // formData = new FormData();
        for( let k in data ){
            // formData.append(k, data[k]);
            formData.push(`${k}=${data[k]}`);
        }
    }

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
    xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    xhr.send(formData.join("&"));
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
    this.post = function (url, data, callback) {
        xhr_func('POST', url, data, callback);
    }
    this.put = function (url, data, callback) {
        xhr_func('PUT', url, data, callback);
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

        if ( document.querySelector(`.${this.data.type} ul .nodata`) ) {
            document.querySelector(`.${this.data.type} ul`).removeChild(document.querySelector(`.${this.data.type} ul .nodata`));
        }

        this.tpl = this.tpl.replace('{%title%}', this.data.title);

        let created_at = this.data.regDate.year + "/" + this.data.regDate.monthValue + "/" + this.data.regDate.dayOfMonth;
        this.tpl = this.tpl.replace('{%regdate%}', created_at);

        this.tpl = this.tpl.replace('{%name%}', this.data.name);
        this.tpl = this.tpl.replace('{%sequence%}', this.data.sequence);

        let li = document.createElement("li");
        li.innerHTML = this.tpl;

        li.setAttribute("class", "todo-item");
        li.setAttribute("data-id", this.data.id);
        li.setAttribute("data-grp", this.data.type);

        if( this.data.type != 'done'){
            let nextBtn = document.createElement("button");
            nextBtn.textContent = "\>";
            nextBtn.addEventListener('click',function(e){
                e.preventDefault();
                let li = this.closest("li");
                let data = { type: li.getAttribute('data-grp') };
                ajax.put(`/api/v1/todos/${li.getAttribute('data-id')}`, data, updateTodoType);
            });
            li.children[1].append(nextBtn);
        }

        let ul = document.querySelector(`.${this.data.type} ul`);
        ul.append(li);
    }
    this.noData = function(className = 'todo'){
        let li = document.createElement("li");
        li.setAttribute("class", "nodata");
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

function getNewTodo (data) {
    console.log(data);
    new Item(data).render();
    modal.style.display = "none";
    document.querySelector('#input-modal form #title').value = "";
    document.querySelector('#input-modal form #name').value = "";
    document.querySelector('#input-modal form .sequence [type="radio"]:checked').checked = false;
}

function updateTodoType (data) {
    document.querySelector(`section.${data.type} ul`).append(
        document.querySelector(`li[data-id="${data.id}"]`)
    );

    /*TODO::
        if now null, render null li
        if now not null, remove null li
        data-grp change
     */
}

document.querySelector('header button').addEventListener('click', function(e){
    modal.style.display = "unset";
    document.querySelector('#input-modal form #title').focus();
});
document.querySelector('#input-modal .btns #cancel').addEventListener('click', function(e){
    e.preventDefault();
    document.querySelector("#input-modal").style.display = "none";
});

document.querySelector('#input-modal form').addEventListener('submit', function(e){
   e.preventDefault();

   let data = {};
   data.title = document.querySelector('#input-modal form #title').value;
   data.name = document.querySelector('#input-modal form #name').value;
   data.sequence = document.querySelector('#input-modal form .sequence [type="radio"]:checked').value;

    ajax.post("/api/v1/todos", data, getNewTodo);
});

/*
*    todo::  make done, erase button
* */
