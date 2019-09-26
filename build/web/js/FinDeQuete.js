/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function () {

    var bt = $('[name="submit"]');

    bt.click(function () {
        var t = $(this);
        var nom = t.next().html();
        var prenom = t.next().next().html();
        
        data = {
          message : "insertion",
          type = "primary"
        };
        
        $.getJSON('ProjetJDR/Ajax_FinDeQuete' , {
            nom : nom,
            prenom : prenom
        }, function(data) {
            if(data.fail) {
                
            } else if(data.error) {
                
            } else {
                
            }
        }).error(function() {
            
        });
    });

});

