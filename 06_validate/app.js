let myForm = document.myForm;
myForm.addEventListener('submit', (e) => {
    e.preventDefault();
    let emailValid = (/(^\D)([a-zA-Z0-9_]+)@([0-9a-zA-Z\._-]+)/).test(myForm.email.value);
    if( !emailValid ){
        document.querySelector('.email-sec input').classList.add('border-red-500');
        document.querySelector('.email-sec p.error-message').textContent = 'email validate fail';
    }
});