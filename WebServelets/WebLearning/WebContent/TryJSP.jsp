<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cadastramento</title>
</head>
<body>
	<form name = "CadastroUsuario" id="CadastroId" method="post" action="ServeletTry">
		<fieldset>
			<legend>Cadastro</legend>
			Nome:
			<input type="text" 	name="name" size="60" placeholder="Digite o seu nome" required/>
			<br>
			<br>
			
			Sexo:
			<input type="radio" name="sex" value="male" />Masculino
			<input type="radio" name="sex" value="female"  />Feminino
			<input type="radio" name="sex" value="undefined"  />Outros
			<br>
			<br>
			Objetivo
			<br>
			<textarea name="objective" cols="35" rows="5" placeholder="Digite o seu objetivo" required></textarea>
			<br>
			<br>
			
			<table border="2">
				<th> Conhecimento de Linguagens de programação </th>
				<th> <input type="checkbox" onchange="selectAll(this)" name="linguaguem_programacao" /></th>
				<tr>
					<td> C/C++ </td>
					<td> <input type="checkbox" id="formation1" name="linguaguem_programacao" value="C/C++" /> </td>
				</tr>
				<tr>
					<td> Java</td>
					<td><input type="checkbox" id="formation2" name="linguaguem_programacao" value="Java" /></td>
				</tr>
				<tr>
					<td> Visual Basic</td>
					<td><input type="checkbox" id="formation3" name="linguaguem_programacao" value="Visual Basic" /></td> 
				</tr>
				<tr>
					<td> PHP</td>
					<td><input type="checkbox" id="formation4" name="linguaguem_programacao" value="PHP" /></td>
				</tr>
				<tr>
					<td> Html</td>
					<td><input type="checkbox" id="formation5" name="linguaguem_programacao" value="HTML" /> </td>
				</tr>
			</table>
			
			<br>
			<img src="images/linkedin.png" width="18px" lenght="18px">
    		<input type="text" name="linkedin" size="37" placeholder="Perfil linkedin"/>
    		<br>
    		<br>
    		Tipo:
			<input type="radio" name="sendType" value="redirect"/>Redirect
			<input type="radio" name="sendType" value="forward"/>Forward
			<br>
    				
		</fieldset>
		
	</form>
	<br>
	<button onClick="signUp()" value="Submit form">Cadastrar</button>
	<button onClick="goBack()" >Voltar</button>
	<br>
</body>

<script>
	function signUp()
	{
		document.getElementById("CadastroId").submit();
	}
	
	function goBack()
	{
		var confirmGoBack = confirm("Voltando perdera todos os dados digitados.\nTem certeza que deseja voltar ?");
		
		if(confirmGoBack == true)
		{
			location.href="Index.jsp";
		}
	}
	
	function selectAll(masterSelected)
	{
		
		var checkboxes = document.getElementsByTagName("input");

		if(masterSelected.checked)
		{
			checkOrUncheckAll(checkboxes, true);
		} 
		else 
		{
			checkOrUncheckAll(checkboxes, false);
		}
		
	}
	
	function checkOrUncheckAll(inputElement, check)
	{
		for (var i=0; i<inputElement.length; i++)
		{
			if(inputElement[i].type == "checkbox")
			{
				inputElement[i].checked = check;
			}
		}
	}
	
</script>
</html>