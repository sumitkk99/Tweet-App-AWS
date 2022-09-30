import { HttpGet } from "../../services/api-services";
import { BASE_URI, GET_USER, LOGOUT } from "../../constants/endpoints";

export const fetchLoggedInUserDetails = async () => {
    try {
        let credentials = "Bearer " + localStorage.getItem("token");
        let apiUrl = BASE_URI + GET_USER + localStorage.getItem("loginId");
        let headers = {
            "Authorization": credentials
        }
        let response = await HttpGet(apiUrl, {}, headers)
        return response.data;
    } catch (e) {
        throw e;
    }
}

export const logout = async () => {
    try {
        let credentials = "Bearer " + localStorage.getItem("token");
        let apiUrl = BASE_URI + LOGOUT + localStorage.getItem("loginId");
        let headers = {
            "Authorization": credentials
        }
        await HttpGet(apiUrl, {}, headers)
    } catch (e) {
        throw e;
    }
}
