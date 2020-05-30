// const Alpha = function (a) {
//     this.result = a;
//
//     this.callbackWrapper = function (callback, args) {
//         return callback(args);
//     }
//
//     this.get = function () {
//         this.result += 3;
//         return this;
//     }
//     this.then = function (callback) {
//         this.callbackWrapper(callback, this.result);
//     }
// }
//
// new Alpha(3).get().then((result) => {
//     console.log(result);
// });

Object.prototype.convertRequestBodyFormData = function () {
    let formData = [];
    for( let k in this ){
        if ( typeof this[k] === "function") continue;
        formData.push(`${k}=${this[k]}`);
    }
    return formData.join("&");
}

const obj = {
    a: "apple",
    b: "banana",
    c: "cherry"
}

console.log( obj.convertRequestBodyFormData() );