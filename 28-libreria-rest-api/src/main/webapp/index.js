console.log("start...")

const onBtnClick = (e) => {
    console.dir(e);
    loadData(e,e.target.id,e.target.id === 'autori' ? 'cognome'
            : e.target.id === 'libri' ? 'titolo': 'nome');
}

const loadData = (e,id,field) => {
fetch(`http://localhost:8080/28-libreria-rest-1.0/api/${id}`)
        .then(resp => resp.json())
        .then(json => {
            viewData(json,field);
        })    
}



const viewData = (json,field) => {
    const ulElement = document.getElementById('elenco');
    ulElement.innerHTML = '';
    json.map(v => {
                const liElement = document.createElement("li");
                liElement.innerHTML = v[field];
                return liElement;
            })
        .forEach(v => ulElement.appendChild(v));
}

document.getElementById("autori")
        .addEventListener("click",onBtnClick);
document.getElementById("libri")
        .addEventListener("click",onBtnClick);
document.getElementById("categorie")
        .addEventListener("click",onBtnClick);


