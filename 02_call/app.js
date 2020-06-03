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