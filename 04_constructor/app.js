function Health (name, timeData){
    this.name = name;
    this.timeData = new Date(timeData);
}

Health.prototype.setName = function (name) {
    this.name = name;
}

Health.prototype.getName = function () {
    return this.name;
}

Health.prototype.setDate = function (timeData) {
    this.timeData = new Date(timeData);
}

Health.prototype.getTimeData = function () {
    return this.timeData;
}

let o = new Health("sunday00", "2020-06-10 00:01:13");

