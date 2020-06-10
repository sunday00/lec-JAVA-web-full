let str1 = "Officia irure conse150ctetur adipisi261cing proid71ent pariatur dolor Lorem mollit in culpa. Ea pariatur aliquip consequat repreh7enderit sint mollit cillum ullamco ex6709cepteur nulla pariatur ea elit. Non magna enim enim ex. Sint anim nostrud reprehenderit et esse excepteur et excepteur. Exercitation eiusmod sint in aliquip aliqua id Lorem.";
let result = str1.match(/\d\d/g);
console.log(result);

let result2 = str1.match(/[348]/g);
console.log(result2);
let result3 = str1.match(/[3489]/g);
console.log(result3);

let result4 = str1.match(/c\w+r/g);
console.log(result4);

let str2 = "apple banana cherry 789 902 avocado durian Egg fortuneCookie";
let result5 = str2.match(/(a[\w\s]+)([0-9]{3}\s[0-9]{3})(\s[a-zA-Z]+)/g);
console.log(result5);
// (...)  is group. can call $1, $2... so if you want to modify str2 to apple...cherry 444 444 avocado ...
                // replace to $1444$3
let result6 = str2.replace(/(a[\w\s]+)([0-9]{3}\s[0-9]{3})(\s[a-zA-Z]+)/g, "$1444 444$3");
console.log(result6);

let result7 = str2.match(/(\w|\W)*\s/);
let result8 = str2.match(/(\w|\W)*?\s/);
console.log(result7);
console.log(result8);
    // even not using global flag, * means find pattern as many as possible. (greedy)
    // using ? with * means find first one only. (lazy)

    