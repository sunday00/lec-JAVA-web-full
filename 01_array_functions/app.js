const data = [
    {title: "apple", content: "red fruit", price:"1200"},
    {title: "banana", content: "yellow fruit", price:"2033"},
    {title: "monk", content: "artist", price:"99999"},
];

let newData = data.map(function (v) {
    let obj = { ...v }
    obj.price = Math.floor(obj.price * 10.1);
    obj.price = (obj.price + '').split('').reverse().map((v, i) => { return (i%3) == 2 ? "," + v : v }).reverse().join("");
    return obj;
});

console.table( newData );

const data2 = [1,4,5,7,9,5,3,5,7,3];
let result2 = data2.reduce((history, v) => {
    return history < v ? v : history;
});

console.log(result2);
