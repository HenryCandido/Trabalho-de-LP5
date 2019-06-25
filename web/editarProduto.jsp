<%-- 
    Document   : editarProduto
    Created on : 09/05/2018, 17:45:17
    Author     : CGARA
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="./css/estilo.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <title>Edição de Produtos</title>
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


        <form action="FrontController?action=EditarProduto" method="post" name="frmCadastrarProduto" onsubmit="">

            <div class="form-row">
                <div class="form-group col-md-10">
                    
                    <input type="hidden" name="textId" value="${produto.id}" class="form-control" >
                </div>
            </div>
            <div class="form-row">
                <div class="form-group col-md-10">
                    <label for="textNome">Nome</label>
                     <input type="text" class="form-control" name="textNome" value="${produto.nome}" class="form-control">

                </div>
            </div>

            <div class="form-row">
                <div class="form-group col-md-10">
                    <label for="textPeso">Peso</label>
                    <input type="text" class="form-control" name="textPeso" value="${produto.peso}">
                </div>
            </div>
            <div class="form-row">
                <div class="form-group col-md-10">
                    <label for="textRemetente">Remetente</label>
                    <input type="text" value="${produto.remetente}" class="form-control" name="textRemetente" placeholder="Nome de quem ta enviando">
                </div>
            </div>
            <div class="form-row">
                <div class="form-group col-md-10">
                    <label for="textDestinatario">Destinatario</label>
                    <input type="text" class="form-control" value="${produto.destino}" name="textDestinatario" placeholder="Nome do Destino">
                </div>
            </div>
            

            <button type="submit" class="btn btn-primary">Editar Produto</button>
        </form>

        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    </body>
</html>
