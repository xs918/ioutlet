/*
 * Version Control Info
 *
 * $Id: main.js,v 1.39 2010/12/24 05:00:58 wsoe Exp $
 * $Revision: 1.39 $
 * $Date: 2010/12/24 05:00:58 $
 */

var browser=navigator.appName;
function showMe(elementId)
{
	var obj = document.getElementById(elementId);
	obj.style.display = "block";
}function showMe(elementId)
{
	var obj = document.getElementById(elementId);
	obj.style.display = "block";
}
function showTd(elementId)
{
 	if(browser == "Microsoft Internet Explorer")
	{
		showMe(elementId);
	}
	else
	{
		var obj = document.getElementById(elementId);
		obj.style.display = "table-cell";
	}
}
function hideMe(elementId)
{
	var obj = document.getElementById(elementId);
	obj.style.display = "none";
}
function showMeInLine(elementId)
{
	var obj = document.getElementById(elementId);
	obj.style.display = "inline";

}

function showOrHideMe(elementId)
{
	var obj = document.getElementById(elementId);
	if(obj.style.display == "block")
	{
		obj.style.display = "none";
	}
	else
	{
		obj.style.display = "block";
	}
}
function submitForm(formName, at)
{
	document.all.pleasewaitdiv.value = 1;
	document.forms[formName].actionType.value = at;
	document.forms[formName].submit();
}



function changeCss(obj,cssClass)
{
	obj.className = cssClass;
}


function isChecked(formName, checkBoxName)
{
	if(document.forms[formName].elements[checkBoxName].checked == false)
	{
		alert('checked');
	}
	else
	{
		alert('not-checked');
	}
}

function isCancel(formid)
{
	document.forms[formid].elements['model.actionType'].value = 'cancelAct';
}

function isReset(formid)
{
	document.forms[formid].elements['model.actionType'].value = 'resetAct';
	document.forms[formid].elements['model.buttonType'].value = 'reset';
}

function isCustomReset(formid, buttonName)
{
	document.forms[formid].elements['model.actionType'].value = 'resetAct';
	document.forms[formid].elements['model.buttonType'].value = buttonName;
}

function isCustomSubmit(formid, buttonName)
{
	document.forms[formid].elements['model.actionType'].value = 'submitAct';
	document.forms[formid].elements['model.buttonType'].value = buttonName;
}

function isCustomSubmit3(formid, buttonName, option)
{
	document.forms[formid].elements['model.actionType'].value = 'submitAct';
	document.forms[formid].elements['model.buttonType'].value = buttonName;
	document.forms[formid].elements['model.option'].value = option;
}

function isCustomSubmit2(formid, option)
{
	document.forms[formid].elements['model.actionType'].value = 'submitAct';
	document.forms[formid].elements['model.option'].value = option;
}

function isSortBy(formid)
{
	document.forms[formid].elements['model.actionType'].value = 'sortBy';
}

function isSearch(formid)
{
	document.forms[formid].elements['model.actionType'].value = 'searchAct';
}

function isCustomSearch(formid, buttonName)
{
	alert("isCustomSearch");
	document.forms[formid].elements['model.actionType'].value = 'searchAct';
	document.forms[formid].elements['model.buttonType'].value = buttonName;
}

// for Client Availability Sheet use
function isRequest(formid)
{
	document.forms[formid].elements['model.actionType'].value = 'requestAct';
}

function isForward(formid)
{
	document.forms[formid].elements['model.actionType'].value = 'forwardAct';
}

/**Using JQUERY to decode encoded html text**/
function htmlDecode(value) {
	return (typeof value === 'undefined') ? '' : $('<div/>').html(value).text();
}



function disable(item)
{
	item.disabled=true; 
}
function enable(item)
{
	item.disabled=false;
}
function disableById(elementId)
{
	var obj = document.getElementById(elementId);
	obj.disabled=true;
	obj.style.backgroundColor="graytext";
}
function enableById(elementId)
{
	var obj = document.getElementById(elementId);
	obj.disabled=false;
	obj.style.backgroundColor="white";
}

function setFocus(elementId)
{
	var obj = document.getElementById(elementId);
	obj.focus();
	obj.style.backgroundColor = "red";
}

function showMe(elementId)
{
	var obj = document.getElementById(elementId);
	obj.style.display = "block";
}
function hideMe(elementId)
{
	var obj = document.getElementById(elementId);
	obj.style.display = "none";
}

function hideMeInLine(elementId)
{
	var obj = document.getElementById(elementId);
	obj.style.display = "none";
}


function trim(pstrData) {
	
   var strCurrentChar=new String();
   
   // Check for spaces at the beginning of the string
   strCurrentChar=pstrData.substring(0, 1);
   	while (strCurrentChar== " ") { 
      pstrData= pstrData.substr(1, pstrData.length);
      strCurrentChar= pstrData.substr(0, 1);
   }
   
   // Check for spaces at the end of the string
   strCurrentChar= pstrData.substring(pstrData.length-1, pstrData.length);
   while (strCurrentChar == " ") { 
      pstrData= pstrData.substr(0, pstrData.length-1);
      strCurrentChar= pstrData.substr(pstrData.length-1, pstrData.length);
   }

   return pstrData; 
} 



function redirect(url)
{
	document.all.pleasewaitdiv.value = 1;
	window.location=url;	
}


function isCustomBack(formid ,buttonName)
{
	document.forms[formid].elements['model.actionType'].value = 'backAct';
	document.forms[formid].elements['model.buttonType'].value = buttonName;
}
function isBack(formid)
{
	alert("isBack:"+formid);
	
	document.forms[formid].elements['model.actionType'].value = 'backAct';
}

function isSubmit(formid)
{
	alert("isSubmit");
	document.forms[formid].elements['model.actionType'].value = 'submitAct';

	
}


function GOTO(url)
{
	window.location.replace(url);
}