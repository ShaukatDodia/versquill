import axios from "axios";

const  REST_API_BASE_URL ='http://localhost:8080/'

export const addUser = (newUser) => axios.post(REST_API_BASE_URL + "registerUser", newUser)