let p = document.querySelector('p');

document.getElementById("image").addEventListener('change', (e) => {
    let images = e.target.files;
    
    let img = new Image();
    img.src = window.URL.createObjectURL(images[0]);
    img.onload = () => {
        if( p.childElementCount === 0 ){
            let el = document.createElement('img');
            el.src = img.src;
            p.appendChild(el);
        } else {
            document.querySelector('p img').src = img.src;
        }
        
    }
});