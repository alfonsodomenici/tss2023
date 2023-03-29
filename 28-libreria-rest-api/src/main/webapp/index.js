console.log("start...")


const onAutoriClick = (e) => {
fetch("http://localhost:8080/28-libreria-rest-1.0/api/autori")
        .then(resp => resp.json())
        .then(json => {
            viewData(json);
        })    
}

const viewData = (json) => {
    const ulElement = document.getElementById('elenco');
    json.map(v => {
                const liElement = document.createElement("li");
                liElement.innerHTML = v.cognome + ' - ' + v.nome;
                return liElement;
            })
        .forEach(v => ulElement.appendChild(v));
}

const btnAutori = document.getElementById("btnAutori");
btnAutori.addEventListener("click",onAutoriClick);


