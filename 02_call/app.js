'use strict';

let apple = {
    color: "red",
    getColor() {
        console.log(this.color);
    }
}

let banana = {
    color: "yellow",
    getColor() {
        console.log(this.color);
    }
}

banana.getColor.call(apple);

function cherry (a, b) {
    this.a = a;
    this.b = b;
    this.sum = function () { return this.a + this.b; }
    this.lazySum = function () {
        setTimeout(function () {
            console.log( this.a + this.b );
        }, 500);
    }
    this.lazySum2 = function () {
        setTimeout(function () {
            console.log( this.a + this.b );
        }.bind(this), 500);
    }
    this.lazySum3 = () => {
        setTimeout(() => {
            console.log( this.a + this.b );
        }, 500);
    }
    this.lazySum4 = () => {
        setTimeout(function () {
            console.log( this.a + this.b );
        }.bind(this), 500);
    }
}

let c = new cherry(1, 3);

c.lazySum();
c.lazySum2();
c.lazySum3();
c.lazySum4();


function abc () {}

console.log( typeof abc );
console.log( typeof abc.bind(this) );