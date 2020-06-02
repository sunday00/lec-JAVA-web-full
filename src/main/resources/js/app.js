let ajax;
let cnf;

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

function replaceProductTemplateToHtmlElement(template, item){
    return template.replace("{{event_url}}", `/product/show/${item.id}`)
        .replace("{{event_title}}", item.title)
        .replace("{{event_thumbnail}}", `/img/${item.thumbnail}`)
        .replace("{{event_adr}}", item.address)
        .replace(/{{event_dsc}}/g, item.description);
}

function replaceCategoryTemplateToHtmlElement(template, item){
    return template.replace("{{category_name}}", item.name);
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

function renderProductCount(count){
    let target = document.querySelector(".event .event_lst_txt span.pink");
    target.textContent = `${count}개`;
    cnf.current_category_total = count;
}

function renderProduct(results){
    let target = document.querySelectorAll(".event .wrap_event_box .lst_event_box");
    let template = document.querySelector("script#itemList").innerHTML;
    results.forEach((item, idx) => {
        let el = document.createElement('li');
        el.className = "item";
        el.innerHTML = replaceProductTemplateToHtmlElement(template, item);
        target[idx % 2].append(el);
    });

    cnf.rendered_cnt = target[0].querySelectorAll('li').length + target[1].querySelectorAll('li').length;

    if ( cnf.rendered_cnt < cnf.current_category_total ){
        cnf.nextPage++;
    } else {
        document.querySelector(".event .wrap_event_box .more").style.display = "none";
    }
}

function renderMoreBtn () {
    let target = document.querySelector(".event .wrap_event_box .more");
    target.firstElementChild.addEventListener("click", (e)=>{
        ajax.get(`/api/product/${cnf.category}/${cnf.nextPage}`).then(renderProduct);
    });
}

FrontConfig = function () {
    this.nextPage = 1;
    this.category = 'all';
    this.current_category_total = 0;
    this.rendered_cnt = 0;
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
        ajax = new AJAX();
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

window.addEventListener('load', () => {
    ajax = new AJAX();
    cnf = new FrontConfig();

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


    ajax.get('/api/category/list').then((results) => {
        let target = document.querySelector(".event .section_event_tab ul.event_tab_lst");
        let template = document.querySelector("script#categoryItem").innerHTML;
        results.forEach((item, idx) => {
            let el = document.createElement('li');
            el.className = "item";
            el.setAttribute("data-category", item.id);
            el.innerHTML = replaceCategoryTemplateToHtmlElement(template, item);

            el.addEventListener("click", (e)=>{

                document.querySelector(".event .section_event_tab ul.event_tab_lst a.active").className = "anchor";
                (e.currentTarget).querySelector(".anchor").className = "anchor active";

                document.querySelectorAll(".event .wrap_event_box .lst_event_box").forEach((ul) => {
                    ul.innerHTML = "";
                });

                cnf.nextPage = 1;
                cnf.category = item.id;
                cnf.current_category_total = 0;
                cnf.rendered_cnt = 0;
                document.querySelector(".event .wrap_event_box .more").style.display = "";

                ajax.get(`/api/product/count/${item.id}`).then((results) => {
                    renderProductCount(results);
                });
                ajax.get(`/api/product/${item.id}/1`).then((results)=>{
                    renderProduct(results);
                });
            });

            target.append( el );
        });
    });

    ajax.get('/api/product/count/all').then((results) => {
        renderProductCount(results);
    });

    ajax.get("/api/product/all/1").then((results)=>{
        renderProduct(results);
        renderMoreBtn ();
    });
});

