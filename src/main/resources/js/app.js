Object.prototype.convertRequestBodyFormData = function () {
    let formData = [];
    for( let k in this ){
        if ( typeof this[k] === "function") continue;
        formData.push(`${k}=${this[k]}`);
    }
    return formData.join("&");
}

function replacePromotionTemplateToHtmlElement(template, item){
    return template.replace("{{event_url}}", `/product/show/${item.id}`)
        .replace("{{event_title}}", item.title)
        .replace("{{event_adr}}", item.address)
        .replace("{{event_dsc}}", item.description);
}

function animatePromotionElements (option) {

    let movingAnimateCssDom = document.createElement('style');
    movingAnimateCssDom.innerHTML = `${option.parent}.active { transition: transform ${option.movingSpeed}ms; }`;
    document.querySelector('head').appendChild(movingAnimateCssDom);

    function actualAnimateRepeat(option){
        let parent = document.querySelector(option.parent);
        let notActiveClassName = parent.className;
        let firstChildLi = document.querySelector(option.item);

        setTimeout(() => {
            parent.className += " active";
            parent.style.transform = "translateX(-100%)";
        }, option.stopTime / 2);

        setTimeout(() => {
            parent.className = notActiveClassName;
            parent.appendChild(firstChildLi);
            parent.style.transform = "translateX(0)";
            actualAnimateRepeat(option);
        }, option.stopTime);
    }

    actualAnimateRepeat(option);
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
        let target = document.querySelector(".event ul.visual_img");
        let template = document.querySelector("script#promotionItem").innerHTML;
        results.forEach((item, idx) => {
            let el = document.createElement('li');
            el.className = "item";
            el.innerHTML = replacePromotionTemplateToHtmlElement(template, item);
            el.style.backgroundImage = `url(/img/${item.thumbnail})`;
            target.append( el );
        });

        animatePromotionElements({
            parent: '.visual_img',
            item: '.event .visual_img li.item',
            stopTime: 1000,
            movingSpeed: 50
        });
    });
});


