<%-- 
    Document   : NovoProduto
    Created on : 03/03/2017, 22:40:32
    Author     : aluno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Novo contato</title>
    </head>
    <body>
        <h1>Novo contato:</h1>
        <p><form method="POST" >
            Nome: <input type="text" size="30" name="nome" />  <br>
            Sobrenome: <input type="text" size="30" name="sobrenome" /> <br>
            telefone: <input type="text" size="10" maxlength="9" name="telefone" /> <br>
            
            <input type="submit" value="Enviar"  />
            
         
         </form>                 
        </p>
    </body>
    </body>
</html>
