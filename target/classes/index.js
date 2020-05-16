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

AJAX = function(){
    this.get = function (url, callback){
        xhr_func('GET', url, null, callback);
    }
}

// xhr_func( 'GET', "/api/v1/todos" );

let ajax = new AJAX();
ajax.get("/api/v1/todos", getAllTodos);

function getAllTodos (data) {
    if( !data.length ){
        console.log("no data");
    } else {
        console.log(data);
    }
}


