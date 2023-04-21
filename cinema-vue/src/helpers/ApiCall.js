import { useAuthStore } from "@/stores";
import { config } from "@/app.config.js";

const get = async (url, body) => {
    const resp = await fetch(url, createRequestOptions(url, "GET", body));
    checkResponse(resp);
    return isJsonResponse(resp) ? await response.json() : null;
};

const post = async (url, body) => {
    const resp = await fetch(url, createRequestOptions(url, "POST", body));
    checkResponse(resp);
    return isJsonResponse(resp) ? await resp.json() : null;
};

const createRequestOptions = (url, method, body) => {
    const reqOptions = {};
    const { isLogged, token, logout } = useAuthStore();
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
    if (resp.ok) {
        return;
    }
    if ([401, 403].includes(resp.status) && isLogged) {
        // auto logout if 401 Unauthorized or 403 Forbidden response returned from api
        logout();
    }
    throw new Error("Network response was not OK");
};

const isJsonResponse = (resp) => {
    const result = resp.headers?.get("content-type")?.includes("application/json");
    return result;
};
export {get,post}
