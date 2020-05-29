const Alpha = function (a) {
    this.result = a;

    this.callbackWrapper = function (callback, args) {
        return callback(args);
    }

    this.get = function () {
        this.result += 3;
        return this;
    }
    this.then = function (callback) {
        this.callbackWrapper(callback, this.result);
    }
}

new Alpha(3).get().then((result) => {
    console.log(result);
});