/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function () {
    var buttonPerso = $('[name="perso"]');
    var fichePerso = $('table');

    fichePerso.attr({
        'hidden': true
    });

    buttonPerso.click(function () {

        var t = $(this);
        var value = t.html();

        var list = fichePerso.children();

        for (var i = 0; i < list.length; i += 2) {
            if (list[i]['outerText'].trim() == value) {
                fichePerso.hide();
                $('[name="' + value + '"]').show();
            }
        }

        buttonPerso.removeClass("btn active");
        buttonPerso.addClass("btn");

        t.removeClass("btn");
        t.addClass("btn active");

    });
});
