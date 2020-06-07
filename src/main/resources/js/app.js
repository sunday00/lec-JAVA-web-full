Object.prototype.convertRequestBodyFormData = function () {
    let formData = [];
    for( let k in this ){
        if ( typeof this[k] === "function") continue;
        formData.push(`${k}=${this[k]}`);
    }
    return formData.join("&");
}

// mainPage

let ajax;
let cnf;

function replacePromotionTemplateToHtmlElement(template, item){
    return template.replace("{{event_url}}", `/display/show/${item.id}`)
        .replace("{{event_title}}", item.title)
        .replace("{{event_adr}}", item.address)
        .replace("{{event_dsc}}", item.description);
}

function replaceProductTemplateToHtmlElement(template, item){
    return template.replace("{{event_url}}", `/display/show/${item.id}`)
        .replace("{{event_title}}", item.title)
        .replace("{{event_thumbnail}}", `/img/${item.thumbnail}`)
        .replace("{{event_adr}}", item.address)
        .replace(/{{event_dsc}}/g, item.description);
}

function replaceCategoryTemplateToHtmlElement(template, item){
    return template.replace("{{category_name}}", item.name);
}

function refreshForCategory(e, itemId){
    document.querySelector(".event .section_event_tab ul.event_tab_lst a.active").className = "anchor";
    (e.currentTarget).querySelector(".anchor").className = "anchor active";

    document.querySelectorAll(".event .wrap_event_box .lst_event_box").forEach((ul) => {
        ul.innerHTML = "";
    });

    cnf.nextPage = 1;
    cnf.category = itemId;
    cnf.current_category_total = 0;
    cnf.rendered_cnt = 0;
    document.querySelector(".event .wrap_event_box .more").style.display = "";

    ajax.get(`/api/display/count/${itemId}`).then((results) => {
        renderProductCount(results);
    });
    ajax.get(`/api/display/${itemId}/1`).then((results)=>{
        renderProduct(results);
    });
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
        ajax.get(`/api/display/${cnf.category}/${cnf.nextPage}`).then(renderProduct);
    });
}

const FrontConfig = function () {
    this.nextPage = 1;
    this.category = 'all';
    this.current_category_total = 0;
    this.rendered_cnt = 0;
}


// detailPage
function animateDetailElements(option) {
    let movingAnimateCssDom = document.createElement('style');
    movingAnimateCssDom.innerHTML = `${option.parent} { transition: transform ${option.movingSpeed}ms; }`;
    document.querySelector('head').appendChild(movingAnimateCssDom);

    const visualParent = document.querySelector(option.parent);
    let visualLis = visualParent.querySelectorAll("li");
    visualLis.forEach((el) => {
        let img = el.querySelector('img');
        if ( img.offsetHeight < el.offsetHeight) {
            img.style.position = 'relative';
            img.style.width = 'auto';
            img.style.height = `${el.offsetHeight}px`;
            img.style.left = '50%';
            img.style.transform = 'translateX(-50%)';
        }
    });
    const elementPage = document.querySelector(".pagination .figure_pagination span.num");

    let activeVisualNo = 0;
    document.querySelector(".group_visual .prev").addEventListener('click', (e) => {
        e.preventDefault();
        activeVisualNo --;
        if (activeVisualNo < 0) activeVisualNo = visualLis.length - 1;
        visualParent.style.transform = `translateX(${-100 * (activeVisualNo % visualLis.length)}%)` ;
        elementPage.textContent = `${activeVisualNo + 1}`;
    });
    document.querySelector(".group_visual .nxt").addEventListener('click', (e) => {
        e.preventDefault();
        activeVisualNo ++;
        if (activeVisualNo > visualLis.length - 1) activeVisualNo = 0;
        visualParent.style.transform = `translateX(${-100 * (activeVisualNo % visualLis.length)}%)` ;
        elementPage.textContent = `${activeVisualNo + 1}`;
    });
}

const DetailConfig = function () {
    this.id = location.pathname.split("/").pop();
    this.product_id = document.querySelector("head meta[name='product-id']").getAttribute('content');
}

// route for active js parts
const route = {
    main: "/",
    detail: RegExp(/\/display\/show\/[0-9]{1,3}/),

}

const AJAX = function(){
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

const mainInit = function () {
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
                refreshForCategory(e, item.id);
            });

            target.append( el );
        });
    });

    document.querySelector(".event .section_event_tab ul.event_tab_lst li[data-category='0']").addEventListener("click", (e)=>{
        refreshForCategory(e, "all");
    })

    ajax.get('/api/display/count/all').then((results) => {
        renderProductCount(results);
    });

    ajax.get("/api/display/all/1").then((results)=>{
        renderProduct(results);
        renderMoreBtn ();
    });
}

const detailInit = function () {

    cnf = new DetailConfig();

    animateDetailElements({
        parent: ".group_visual .container_visual ul.visual_img",
        movingSpeed: 500
    });

    document.querySelector(".bk_more").addEventListener('click', (e) => {
       e.preventDefault();
       const description = document.querySelector(".store_details");
       const btnMore = document.querySelector(".bk_more");
       if( description.classList.contains("close3") ){
           description.classList.remove("close3");
           btnMore.classList.remove('_open');
           btnMore.classList.add('_close');
           btnMore.querySelector(".bk_more_txt").textContent = "접기";
           btnMore.querySelector(".fn").classList.remove("fn-down2");
           btnMore.querySelector(".fn").classList.add("fn-up2");
       } else {
           description.classList.add("close3");
           btnMore.classList.remove('_close');
           btnMore.classList.add('_open');
           btnMore.querySelector(".bk_more_txt").textContent = "펼쳐보기";
           btnMore.querySelector(".fn").classList.remove("fn-up2");
           btnMore.querySelector(".fn").classList.add("fn-down2");
       }

    });

    const commentArea = document.querySelector(".section_review_list");
    const cntElement = commentArea.querySelector(".grade_area .join_count .green");
    const scoreTxt = commentArea.querySelector(".grade_area .text_value");
    const scoreStar = commentArea.querySelector(".grade_area .graph_value");
    ajax.get(`/api/comment/score/${cnf.product_id}`).then(( result ) => {
        cntElement.textContent = `${result.cnt}건`;
        scoreTxt.textContent = result.avg.toFixed(1);
        scoreStar.style.width = `${(result.avg / 5) * 100}%`;
    });

    ajax.get(`/api/comment/brief/${cnf.product_id}`);

}

window.addEventListener('load', () => {
    ajax = new AJAX();
    if (location.pathname === "/") mainInit();
    if (route.detail.test(location.pathname)) detailInit();

});

