'use strict';

function solution(name) {
    let A = "A".charCodeAt(0); // 65; MIN;
    let N = "N".charCodeAt(0); // 78; middle; // distance 13;
    let Z = "Z".charCodeAt(0); // 90; MAX;

    let answer = 0;

    let mv = [];
    let distances = [];

    name.split("").forEach((n, i) => {
        let N = n.charCodeAt(0);
        answer += N < 78 ? N - A : Z - N + 1;

        if( n != 'A' ) mv.push(i);
    });

    if( mv.length === 1 &&  name.length / 2 < mv[0]) {
        answer += name.length - mv[0];
        return answer;
    }

    mv.forEach((n,i) => {
        distances.push( i === mv.length - 1 ? name.length - mv[i] + mv[0] : mv[i + 1] - n );
    });

    let backFirst = false;
    let maxADistance = distances.indexOf(Math.max(...distances));
    let d1 = mv[maxADistance];
    let d2 = distances.slice(maxADistance + 1, distances.length).reduce((s,c) => s + c);

    if(d1 > d2 && Math.max(...distances) > d1){
        backFirst = true;
    }

    let cur = mv.indexOf(0) && !backFirst > -1 ? 0 : name.length - mv[mv.length - 1] < mv[0] || backFirst ? mv.length - 1 : 0 ;
    answer += cur === 0 ? mv[cur] : name.length - mv[mv.length - 1];

    while( mv.length ){
        console.log( mv, mv[cur], answer );
        let now = mv[cur];
        let prev = cur === 0 ? mv[mv.length - 1] : mv[cur - 1];
        let next = cur === mv.length - 1 ? mv[0] : mv[cur + 1];

        let nextDistance = next < now ? name.length - now + next : next - now;
        let prevDistance = prev > now ? name.length - prev + now : now - prev;

        mv.splice(cur, 1);

        if( nextDistance <= prevDistance ){
            cur = 0;
            answer += nextDistance;
        } else {
            cur = mv.length - 1 ;
            answer += prevDistance;
        }
    }

    return answer;
}

console.log( solution('AABAAAAAAABBB') );