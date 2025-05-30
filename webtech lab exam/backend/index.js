import express from "express";
import cors from "cors";

import "./db/dbConnection.js";
import workshopModel from "./model/workshopModel.js";

const app = express();

app.use(express.json());
app.use(cors());

app.get("/all", async (req, res) => {
  const workshop = await workshopModel.find();
  res.send(workshop);
});

app.get("/:id", async (req, res) => {
  try {
    const workshop = await workshopModel.findById(req.params.id);
    res.send(workshop);
  } catch (error) {
    console.log(error);
  }
});

app.post("/add", async (req, res) => {
  const addshop = new workshopModel(req.body);
  await addshop.save();

  res.send(" added Sucessfully!");
});

app.put("/:id", async (req, res) => {
  try {
    const shop = await workshopModel.findByIdAndUpdate(req.params.id, req.body);
    res.send(shop);
    res.send("shope updated!");
  } catch (error) {
    console.log(error);
  }
});

app.delete("/:id", async (req, res) => {
  try {
    const shop = await workshopModel.findByIdAndDelete(req.params.id);
    res.send(shop);
  } catch (error) {
    console.log(error);
  }
});

app.listen(9090);
