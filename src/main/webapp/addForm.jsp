<%--
  Created by IntelliJ IDEA.
  User: youcode
  Date: 11/10/2023
  Time: 12:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="form">
  <form action="insert" method="post">
    <center>
      <h2>Ajouter un client</h2>
    </center>
    <div>
      <label>Code</label>
      <input required type="text" placeholder="code" name="code">
    </div>
    <div>
      <label>Prenom</label>
      <input required type="text" placeholder="Prenom" name="firstName">
    </div>
    <div>
      <label>Nom</label>
      <input required type="text" placeholder="nom" name="lastName">
    </div>
    <div>
      <label>adress</label>
      <input required type="text" placeholder="adress" name="adress">
    </div>
    <div>
      <label>Date de naissance</label>
      <input required type="date" name="dateOfBirth">
    </div>
    <div>
      <label>Nombre du telephone</label>
      <input required type="tel" placeholder="nombre de tele" name="phoneNumber">
    </div>
    <center>
      <button type="submit">Ajouter</button>
    </center>
  </form>
</div>
</body>
</html>
<style>
  *{
    font-family: Arial, Helvetica, sans-serif;
  }
  form div{
    display: flex;
    flex-direction: column;
    margin: 8px;
  }
  input {
    width: 100%;
    padding: 12px 20px;
    margin: 8px 0;
    display: inline-block;
    border: 1px solid #ccc;
    border-radius: 4px;
    box-sizing: border-box;
  }
  form {
    margin: auto;
    border-radius: 5px;
    background-color: #f2f2f2;
    padding: 20px;
    width: 400px;
  }
  button {
    color:rgb(255, 255, 255);
    background-color:rgb(18, 119, 221);
    border:1px solid;
    border-radius: 4px;
    padding: 8px 20px;
    font-size: large;
    cursor: pointer;
    font-weight: 400;
    width: 60%;
  }
</style>
