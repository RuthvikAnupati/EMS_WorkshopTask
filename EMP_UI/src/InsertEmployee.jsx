import { useState } from "react";
import {insertEmployee} from "./EmployeeService";

function InsertEmployee(){

    const [employee,setEmployee]= useState ({
        ename : '',
        designation : '',
        age : 0,
        workPlace : '',
    });

    const handleChange = (e) => {
        setEmployee({...employee , [e.target.name]:e.target.value});
    }

    const save = () =>{
        insertEmployee(employee);
    };


    return(
        <div>
            <input type="text" name="ename" onChange={handleChange}></input>
            <input type="text" name="designation" onChange={handleChange}></input>
            <input type="text" name="age" onChange={handleChange}></input>
            <input type="text" name="workPlace" onChange={handleChange}></input>

            <p>{employee.ename}</p>
            <p>{employee.designation}</p>
            <p>{employee.age}</p>
            <p>{employee.workPlace}</p>

            <input type="button" value="SUBMIT" onClick={save} ></input>
        </div>
    )

}
export default InsertEmployee;

