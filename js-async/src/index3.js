console.log('inizio richiesta fetch');

const p1 = Promise.resolve(2);

console.log(p1);

const p2= p1.then(v => {
    return v*2;
});

console.log(p2);

p2.then(value => console.log(value));