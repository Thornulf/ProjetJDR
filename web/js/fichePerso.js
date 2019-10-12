/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var buttonPerso = $('[name="perso"]');

buttonPerso.click(function () {

    var t = $(this);
    t.removeClass("btn");
    t.addClass("btn active");

});
