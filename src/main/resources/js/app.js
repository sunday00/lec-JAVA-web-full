let promotionHtml;

function xhr_func (method, url, data=null, callback = null) {
    let xhr = new XMLHttpRequest();
    let formData = [];
    if( data ){
        for( let k in data ){
            formData.push(`${k}=${data[k]}`);
        }
    }

    xhr.onreadystatechange = function() {
        if (xhr.readyState === xhr.DONE) {
            if (xhr.status === 200 || xhr.status === 201) {
                let results = JSON.parse( xhr.responseText );
                // if callback exists run callback,
                // else return some object including 'then' method that has result and callback as args.
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

function convertTemplateToHtml (tpl, parentHtml, option = {})
{

}

