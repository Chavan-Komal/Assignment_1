import React, { useEffect } from "react";
import { useState } from "react";
import axios from "axios";

const App = () => {
  const [workshops, setshop] = useState();
  const [name, setName] = useState();
  const [price, setPrice] = useState();
  const [trainerName, settrainerName] = useState();
  const [scheduleDate, setscheduleDate] = useState();
  const [id, setId] = useState();

  const fetchshop = async () => {
    const response = await axios.get("http://localhost:9090/all");
    setshop(response.data);
  };
  useEffect(() => {
    fetchshop();
  }, []);

  //to add product
  const handleAdd = async () => {
    await axios.post("http://localhost:9090/add", {
      name: name,
      price: price,
      trainerName: settrainerName,
      scheduleDate: scheduleDate,
    });
  };

  //to get by id
  const handleGetById = async () => {
    const response = await axios.get(
      "http://localhost:9090/68398e6a3829436ee3d28ec2" + id
    );
    console.log(response.data);
    setshop([response.data]);
  };

  //to update
  const handleUpdate = async () => {
    await axios.put("http://localhost:9090/68398e6a3829436ee3d28ec2" + id, {
      name: name,
      price: price,
      trainerName: settrainerName,
      scheduleDate: scheduleDate,
    });
  };

  //to delete
  const handledelete = async () => {
    await axios.delete("http://localhost:9090/68398e6a3829436ee3d28ec2" + id);
  };

  return (
    <>
      <div>
        {workshops &&
          workshops.map((data) => (
            <div>
              <div>{data.name}</div>
             
              <div>{data.price}</div>
              <div>{data.trainerName}</div>
              <div>{data.scheduleDate}</div>
            </div>
          ))}
      </div>

      <h2>getByid</h2>
      <input
        type="text"
        placeholder="id"
        onChange={(e) => setId(e.target.value)}
      />
      <button onClick={handleGetById}>get</button>
      <br />
      <br />
      <h2>Add</h2>
      <input
        type="text"
        placeholder="name"
        onChange={(e) => setName(e.target.value)}
      />
      <input
        type="text"
        placeholder="price"
        onChange={(e) => setPrice(e.target.value)}
      />
      <input
        type="text"
        placeholder="trainername"
        onChange={(e) => settrainerName(e.target.value)}
      />
      <button onClick={handleAdd}>Add</button>
      <br />
      <br />
      <h2>Update</h2>
      <input
        type="text"
        placeholder="name"
        onChange={(e) => setName(e.target.value)}
      />
      <input
        type="text"
        placeholder="price"
        onChange={(e) => setPrice(e.target.value)}
      />
      <input
        type="text"
        placeholder="trainername"
        onChange={(e) => settrainerName(e.target.value)}
      />
      <input
        type="text"
        placeholder="id"
        onChange={(e) => setId(e.target.value)}
      />
      <button onClick={handleUpdate}>Update</button>
      <br />
      <br />
      <h2>Delete</h2>
      <input
        type="text"
        placeholder="id"
        onChange={(e) => setId(e.target.value)}
      />
      <button onClick={handledelete}>Delete</button>
    </>
  );
};

export default App;
