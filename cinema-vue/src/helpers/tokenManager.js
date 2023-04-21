export const storeToken = (t) => {
    sessionStorage.setItem('token', t);
}

export const readToken = () => {
    return sessionStorage.getItem('token');
}

export const removeToken = () => {
    return sessionStorage.removeItem('token');
}

export const isAuthenticated = () => {
    return sessionStorage.getItem('token') !== null;
}

export const parseJwt = _ => {
    const token = readToken();
    if(token === null){
        return undefined;
    }
    const base64Url = token.split('.')[1];
    const base64 = base64Url.replace(/-/g, '+').replace(/_/g, '/');
    const jsonPayload = decodeURIComponent(atob(base64).split('').map(function (c) {
        return '%' + ('00' + c.charCodeAt(0).toString(16)).slice(-2);
    }).join(''));

    return JSON.parse(jsonPayload);
};

export const loggedUserId = _ => {
    return parseJwt()?.sub || null;
}

export const loggedUsername = _ => {
    return parseJwt()?.upn || null;
}

export const isUserInRole = (role) => {
    const  groups  = parseJwt()?.groups;
    return groups ? groups.find(g => g === role) !== undefined : false;
}

