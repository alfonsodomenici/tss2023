console.log('started...')

fetch('http://localhost:8080/cinema-wf-1.0/api/utenti/login',{
    method:"POST",
    headers: {
        "Content-Type": "application/json",
    },
    body: JSON.stringify({usr:'alfonso',pwd:'alfonso'}),
}).then(response => {
    return response.json()
}).then(json => {
    console.log(json);
})