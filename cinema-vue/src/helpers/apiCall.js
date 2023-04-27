import { useAuthStore, useAlertStore } from "@/stores";
import { config } from "@/app.config.js";

const request = async (method, url, body) => {
    const alertStore = useAlertStore();
    const authStore = useAuthStore();
    try {
        alertStore.loading();
        await sleep(1000);
        const resp = await fetch(url, createRequestOptions(method, url, body));
        checkResponse(resp);
        return isJsonResponse(resp) ? await resp.json() : null;
    }catch(error){
        return Promise.reject('errore sul server...' + error)
    } 
    finally {
        alertStore.done();
    }
}

const createRequestOptions = (method, url, body) => {
    const reqOptions = {};
    const { isLogged, token } = useAuthStore();
    const isApiUrl = url.startsWith(config.baseUrl);
    const headers = new Headers();
    if (isLogged && isApiUrl) {
        headers.set("Authorization", `Bearer ${token}`);
    }
    if (body) {
        headers.set("Content-Type", "application/json");
        reqOptions.body = JSON.stringify(body);
    }
    reqOptions.headers = headers;
    reqOptions.method = method;
    return reqOptions;
};

const checkResponse = (resp) => {
    const { isLogged, logout } = useAuthStore();
    if (resp.ok) {
        return;
    }
    if ([401, 403].includes(resp.status) && isLogged) {
        logout();
        return;
    }
    throw new Error(resp.statusText);
};

const isJsonResponse = (resp) => {
    return resp.headers?.get("content-type")?.includes("application/json");
};

const sleep = async (msec) => {
    return new Promise(resolve => setTimeout(resolve, msec));
}

export { request }
