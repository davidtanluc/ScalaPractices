function solution(S, P, Q) {
    var indexes = {
            A: {},
            C: {},
            G: {},
            T: {}
        },

        i,
        min,
        results = [];

    S.split('').forEach(function (el, i) {
        indexes[el][i] = true;
        //console.log("Index", indexes);
    });

    for (i = 0; i < P.length; i++) {
        var min = 4; // ACGT
        for (; P[i] <= Q[i]; P[i]++) {
            if (indexes['A'][P[i]]) {
                min = 1;
                break;
            }
            if (min > 2 && indexes['C'][P[i]]) min = 2;
            if (min > 3 && indexes['G'][P[i]]) min = 3;
        }
        results.push(min);
    }
    return results;
}


var S = "CAGCCTA";
var P = [2, 5, 0];
var Q = [4, 5, 6];
console.log(solution(S, P, Q)); //[2,4,1];

/*
 /usr/local/bin/node GenomicRangeQuery.js
 Index { A: {}, C: { '0': true }, G: {}, T: {} }
 Index { A: { '1': true }, C: { '0': true }, G: {}, T: {} }
 Index { A: { '1': true }, C: { '0': true }, G: { '2': true }, T: {} }
 Index { A: { '1': true }, C: { '0': true, '3': true }, G: { '2': true }, T: {} }
 Index { A: { '1': true }, C: { '0': true, '3': true, '4': true },G: { '2': true },T: {} }
 Index { A: { '1': true },
 C: { '0': true, '3': true, '4': true },
 G: { '2': true },
 T: { '5': true } }

 /////// final for "CAGCCTA"/ ///////////

 Index { A: { '1': true, '6': true },
 C: { '0': true, '3': true, '4': true },
 G: { '2': true },
 T: { '5': true } }


 ///////////////////////////////////
 [ 2, 4, 1 ]

 Process finished with exit code 0
 */