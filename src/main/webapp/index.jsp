<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page import=" jakarta.servlet.http.HttpServletRequest" %>
<!DOCTYPE html>
<html>
<head>
    <title>User Management Application</title>
</head>
<body>
<nav>
    <p class="logo" style="font-weight: bold"><span style="color: rgb(18, 119, 221); font-weight: bolder;">Easy</span>Bank</p>
    <ol id="aah">
        <li><a href="list" class="a">Liste des clients</a></li>
        <li><a href="./Carte.html" class="a">liste des employés</a></li>
        <li><a href="./Apropos.html" class="a">A propos</a></li>
        <li><a href="./Contact.html"><span class="oronge">Contact</span></a></li>
    </ol>
</nav>
<h3 class="text-center">la list des clients</h3>
<hr>
<center>
<form action="list" method="get">
  <div class="grp">
    <input type="text" placeholder="attribut " name="attribut">
  </div>
  <div class="search-btn">
    <button type="submit"><svg xmlns="http://www.w3.org/2000/svg" class="icon icon-tabler icon-tabler-search" width="24" height="24" viewBox="0 0 24 24" stroke-width="2" stroke="currentColor" fill="none" stroke-linecap="round" stroke-linejoin="round">
      <path stroke="none" d="M0 0h24v24H0z" fill="none"></path>
      <path d="M10 10m-7 0a7 7 0 1 0 14 0a7 7 0 1 0 -14 0"></path>
      <path d="M21 21l-6 -6"></path>
    </svg></button>
  </div>
</form>
</center>
<div class="container text-left">
    <div class="div1">
        <a class="addBtn" href="new">
            New Client
        </a>
    </div>
    <center>

        <div class="tableDiv">
            <table class="table table-bordered">
                <thead>
                <tr>
                    <th>Code</th>
                    <th>Nom</th>
                    <th>Prenom</th>
                    <th>Date de naissance</th>
                    <th>Numero du tele</th>
                    <th>Adress</th>
                    <th>Actions</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="client" items="${listClient}">
                    <tr>
                        <td><c:out value="${client.code}"/></td>
                        <td><c:out value="${client.lastName}"/></td>
                        <td><c:out value="${client.firstName}"/></td>
                        <td><c:out value="${client.dateOfBirth}"/></td>
                        <td><c:out value="${client.phoneNumber}"/></td>
                        <td><c:out value="${client.adress}"/></td>
                        <td><a class="editBtn" href="edit?id=<c:out value="${client.code}"/>">
                            <svg xmlns="http://www.w3.org/2000/svg" class="icon icon-tabler icon-tabler-edit" width="24"
                                 height="24" viewBox="0 0 24 24" stroke-width="2" stroke="currentColor" fill="none"
                                 stroke-linecap="round" stroke-linejoin="round">
                                <path stroke="none" d="M0 0h24v24H0z" fill="none"></path>
                                <path d="M7 7h-1a2 2 0 0 0 -2 2v9a2 2 0 0 0 2 2h9a2 2 0 0 0 2 -2v-1"></path>
                                <path d="M20.385 6.585a2.1 2.1 0 0 0 -2.97 -2.97l-8.415 8.385v3h3l8.385 -8.415z"></path>
                                <path d="M16 5l3 3"></path>
                            </svg>
                        </a>

                            
                            <a class="deleteBtn"
                               href="delete?id=<c:out value="${client.code}"/>">
                                <svg xmlns="http://www.w3.org/2000/svg"
                                     class="icon icon-tabler icon-tabler-trash-filled" width="24" height="24"
                                     viewBox="0 0 24 24" stroke-width="2" stroke="currentColor" fill="none"
                                     stroke-linecap="round" stroke-linejoin="round">
                                    <path stroke="none" d="M0 0h24v24H0z" fill="none"></path>
                                    <path d="M20 6a1 1 0 0 1 .117 1.993l-.117 .007h-.081l-.919 11a3 3 0 0 1 -2.824 2.995l-.176 .005h-8c-1.598 0 -2.904 -1.249 -2.992 -2.75l-.005 -.167l-.923 -11.083h-.08a1 1 0 0 1 -.117 -1.993l.117 -.007h16z"
                                          stroke-width="0" fill="currentColor"></path>
                                    <path d="M14 2a2 2 0 0 1 2 2a1 1 0 0 1 -1.993 .117l-.007 -.117h-4l-.007 .117a1 1 0 0 1 -1.993 -.117a2 2 0 0 1 1.85 -1.995l.15 -.005h4z"
                                          stroke-width="0" fill="currentColor"></path>
                                </svg>
                            </a></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </center>
</div>
</body>
</html>
<style>
    ol{
        display: flex;
        list-style: none;
        margin: auto;
    }
    li{
        font-size: 16px;
        margin: 0 2.5rem;
        font-weight: bolder;
    }
    a{
        text-decoration: none;
        color: rgb(18, 119, 221);
    }
    nav{
        display: flex;
        justify-content: space-between;
        place-items: center;
        list-style: none;
        align-content: center;
        height: 95px;
    }
  .search-btn{
    margin: auto;
  }
    form div {
        margin: 8px;
    }
    .grp {
      display: flex;
      flex-direction: column;
    }
    input {
        width: 100%;
        padding: 2px 8px;
        margin: 2px 0;
        display: inline-block;
        border: 1px solid #ccc;
        border-radius: 4px;
        box-sizing: border-box;
    }

    form {
        display: flex;
        flex-wrap: wrap;
        flex-direction: row;
        margin: auto;
        border-radius: 5px;
        background-color: #f2f2f2;
        padding: 4px;
      width: max-content;
    }

    center button {
        color: rgb(255, 255, 255);
        background-color: rgb(18, 119, 221);
        border: 1px solid;
        border-radius: 4px;
        padding: 4px;
        cursor: pointer;
        font-weight: 400;
    }


    .div1 {
        display: flex;
    }

    table {
        border-collapse: collapse;
        width: 80%;
        margin: 20px;
    }

    th {
        background-color: #f2f2f2;
    }

    tr:nth-child(even) {
        background-color: #f2f2f2;
    }

    td, th {
        border: 1px solid #dddddd;
        text-align: left;
        padding: 8px;

    }

    h3 {
        text-align: center;
    }

    hr {
        margin: 10px;
    }

    .addBtn {
        color: rgb(255, 255, 255);
        background-color: rgb(18, 119, 221);
        border: 1px solid;
        border-radius: 4px;
        padding: 4px 10px;
        font-size: medium;
        font-weight: 400;
        text-decoration: none;
        margin-left: 10%;
    }

    .deleteBtn {
        color: #ff5a5a;
    }

    .editBtn {
        color: #41c4a1;
    }

    * {
        font-family: Arial, Helvetica, sans-serif;
    }
</style>