<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!doctype html>
<html lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="./css/bootstrap.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">


        <title>Excluir Produto</title>                                                                        
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
        <div class="container">
            <h1>Excluir Cliente</h1>

            <form action="FrontController?action=ExcluirProduto" method="post" name="frmExcluirProduto" onsubmit="">

                <div class="form-group">
                    <label for="textId">ID:</label>
                    <input type="text" class="form-control" id="textId" name="textId" value="${produto.idProduto}" readonly>
                </div>
                <div class="form-group">
                    <label for="textNome">Nome:</label>
                    <input type="text" class="form-control" id="textNome" name="textNome" value="${produto.nomeProduto}" readonly>
                </div>
                <div class="form-group">
                    <label for="textCep">Peso</label>
                    <input type="text" class="form-control" id="textCep" name="textCep" value="${produto.pesoProduto}" readonly>
                </div>
                <div class="form-group">
                    <label for="textCpf">Origem</label>
                    <input type="text" class="form-control" id="textCpf" name="textCpf" value="${produto.clienteRemetente}" readonly>
                </div>
                <div class="form-group">
                    <label for="textCpf">Destino</label>
                    <input type="text" class="form-control" id="textCpf" name="textCpf" value="${produto.clienteDestinatario}" readonly>
                </div>
                <div class="form-group">
                    <label for="textCpf">Situação</label>
                    <input type="text" class="form-control" id="textCpf" name="textCpf" value="${produto.estado}" readonly>
                </div>
               
                <button type="submit" class="btn btn-default" name="btnConfirmar" value="Confirmar">Confirmar</button>
            </form>
        </div>


        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

    </body>
</html>