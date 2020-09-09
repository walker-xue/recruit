export function getStorage(key) {
    return JSON.parse(sessionStorage.getItem(key));
}

export function setStorage(key, value) {
    return sessionStorage.setItem(key, JSON.stringify(value));
}

export function removeStorage(key) {
    return sessionStorage.removeItem(key);
}
