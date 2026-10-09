import axios from 'axios';

const API_URL = "http://localhost:9991";

export const insertEmployee = (employee) => axios.post(`${API_URL}/createEmp`, employee);
