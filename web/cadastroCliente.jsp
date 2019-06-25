<%-- 
    Document   : cadastroProduto
    Created on : 03/05/2018, 22:39:18
    Author     : dyhre
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="./css/estilo.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

        <title>Cadastro de Clientes</title>
    </head>
    <body>
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <div class="collapse navbar-collapse" id="navbarNavDropdown">
                <ul class="navbar-nav">
                    <li class="nav-item">
                        <a class="nav-link" href="index.jsp">Menu Principal</a>
                    </li>
                    
                </ul>
            </div>
        </nav>


    <legend>Dados do Cliente</legend>

    <form action="FrontController?action=SalvarCliente"  method="post" name="frmCadastrarCliente" onsubmit="">
        <div class="form-row">
            <div class="form-group col-md-10">
                <label for="textId">Id</label>
                <input type="text" class="form-control" name="textId" placeholder="Id do Cliente">
            </div>
        </div>

        <div class="form-row">
            <div class="form-group col-md-10">
                <label for="textNome">Nome</label>
                <input type="text" class="form-control" name="textNome" placeholder="Nome do Cliente">
            </div>
        </div>
        <div class="form-row">
            <div class="form-group col-md-10">
                <label for="textCep">Cep Cliente</label>
                <input type="text" class="form-control" name="textCep" placeholder="Cep do Cliente">
            </div>
        </div>
        <div class="form-row">
            <div class="form-group col-md-10">
                <label for="textCpf">CPF Cliente</label>
                <input type="text" class="form-control" name="textCpf" placeholder="Cpf do Cliente">
            </div>
        </div>
        
        <div class="form-row"> 
            <div class="form-group col-md-10">
                <label for="textTipo">Tipo Cliente</label>
                <select class="form-control" name="textTipo" placeholder="Tipo de cliente">
                    <option>Destinatario</option>
                    <option>Remetente</option>
                </select>
            </div>
        </div>


        <button type="submit" class="btn btn-primary">Cadastrar Cliente</button>
    </form>

    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</body>
</html>
