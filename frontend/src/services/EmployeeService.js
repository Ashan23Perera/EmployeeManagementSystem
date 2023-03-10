import axios from 'axios'

const EMPLOYEE_BASE_REST_API_URL = 'http://localhost:8081/api/v1/employee';

class EmployeeService{

    getAllEmployees(){
        return axios.get(EMPLOYEE_BASE_REST_API_URL)
    }

    createEmployee(employee){
        return axios.post(EMPLOYEE_BASE_REST_API_URL + "/create", employee)
    }

    getEmployeeById(employeeId){
        return axios.get(EMPLOYEE_BASE_REST_API_URL + '/' + employeeId);
    }

}

export default new EmployeeService();