Object.prototype.convertRequestBodyFormData = function () {
    let formData = [];
    for( let k in this ){
        if ( typeof this[k] === "function") continue;
        formData.push(`${k}=${this[k]}`);
    }
    return formData.join("&");
}

AJAX = function(){
    this.ready = false;
    this.results = {};
    this.xhr = new XMLHttpRequest();

    this.xhr_func = function (method, url, data=null, callback = null) {
        this.xhr.onreadystatechange = () => {
            if (this.xhr.readyState === this.xhr.DONE) {
                if (this.xhr.status === 200 || this.xhr.status === 201) {
                    this.results = JSON.parse( this.xhr.responseText );
                    this.ready = true;
                } else {
                    console.error(this.xhr.responseText);
                }
            }
        };

        this.xhr.open(method, url);
        this.xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
        this.xhr.send( data ? data.convertRequestBodyFormData() : null );
    }

    this.get = function (url, callback = null){
        this.xhr_func('GET', url, null);
        return this;
    }

    this.then = function (callback) {
        if ( this.ready ){
            callback(this.results);
        } else {
            setTimeout(()=>{
                this.then(callback);
            }, 50);
        }
    }
}

const ajax = new AJAX();

window.addEventListener('load', () => {
    ajax.get("/api/promotion/all").then(( results )=>{
        console.log(results);
    });
});

