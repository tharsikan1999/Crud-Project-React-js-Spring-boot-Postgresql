import axios from 'axios';
import { useEffect, useState } from "react";

function CustomerCrud() {
  const [userId, setId] = useState('');
  const [userName, setName] = useState("");
  const [password, setAddress] = useState("");
  const [phone, setMobile] = useState("");
  const [customers, setUsers] = useState([]);

  useEffect(() => {
    (async () => await Load())();
  }, []);

  async function Load() {
    const result = await axios.get("http://localhost:8084/get");
    setUsers(result.data);
  }

  async function save(event) {
    event.preventDefault();
    try {
      await axios.post("http://localhost:8084/add", {
        userName: userName,
        password: password,
        phone: phone
      });
      alert("Customer Registration Successfully");
      setId("");
      setName("");
      setAddress("");
      setMobile("");
      Load();
    } catch (err) {
      alert("User Registration Failed");
    }
  }

  async function editCustomer(customer) {
    setName(customer.userName);
    setAddress(customer.password);
    setMobile(customer.phone);
    setId(customer.userId);
  }

 

  async function DeleteCustomer(userId) {
    try {
      await axios.delete(`http://localhost:8084/${userId}`);
      alert("Employee deleted Successfully");
      Load();
    } catch (error) {
      console.error("Delete request failed:", error);
      // Add more error handling or logging as needed
    }
  }
  

  async function update(event) {
    event.preventDefault();
    try {
      await axios.put("http://localhost:8084/update", {
        userId: userId,
        userName: userName,
        password: password,
        phone: phone
      });
      alert("Registration Updated");
      setId("");
      setName("");
      setAddress("");
      setMobile("");
      Load();
    } catch (err) {
      alert("User Registration Failed");
    }
  }
  return (
    <div>
       <h1>Customer Details</h1>
       <div class="container mt-4" >
          <form>
              <div class="form-group">
               <input  type="text" class="form-control" id="customerid" hidden
               value={userId}
               onChange={(event) =>
                {
                  setId(event.target.value);      
                }} 
               />
                <label>Customer Name</label>
                <input  type="text" class="form-control" id="customername"
                value={userName}
                onChange={(event) =>
                  {
                    setName(event.target.value);      
                  }}
                />
              </div>
              <div class="form-group">
                <label>Customer Address</label>
                <input  type="text" class="form-control" id="customeraddress" 
                 value={password}
                  onChange={(event) =>
                    {
                      setAddress(event.target.value);      
                    }}
                />
              </div>

              <div class="form-group">
                <label>Mobile</label>
                <input type="text" class="form-control" id="mobile" 
                  value={phone}
                onChange={(event) =>
                  {
                    setMobile(event.target.value);      
                  }}
                />
              </div>
              <div>
              <button   class="btn btn-primary mt-4"  onClick={save}>Register</button>
              <button   class="btn btn-warning mt-4"  onClick={update}>Update</button>
              </div>   
            </form>
          </div>

<table class="table table-dark" align="center">
  <thead>
    <tr>
      <th scope="col">Customer Id</th>
      <th scope="col">Customer Name</th>
      <th scope="col">Customer Address</th>
      <th scope="col">Customer Mobile</th>
      
      <th scope="col">Option</th>
    </tr>
  </thead>
       {customers.map(function fn(customer)
       {
            return(
            <tbody>
                <tr>
                <th scope="row">{customer.userId} </th>
                <td>{customer.userName}</td>
                <td>{customer.password}</td>
                <td>{customer.phone}</td>        
                <td>
                    <button type="button" class="btn btn-warning"  onClick={() => editCustomer(customer)} >Edit</button>  
                    <button type="button" class="btn btn-danger" onClick={() => DeleteCustomer(customer.customerid)}>Delete</button>
                </td>
                </tr>
            </tbody>
            );
            })}
            </table>
       </div>
            );
        }
 
export default CustomerCrud;