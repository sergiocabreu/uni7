"use strict";
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};
var core_1 = require('@angular/core');
var livro_data_service_1 = require('./livro-data.service');
var AcervoComponent = (function () {
    function AcervoComponent(livroDataService) {
        this.livroDataService = livroDataService;
    }
    AcervoComponent.prototype.ngOnInit = function () {
        var livroDataService = new livro_data_service_1.LivroDataService();
        this.acervo = this.livroDataService.getLivros();
    };
    AcervoComponent.prototype.totalDeLivros = function () {
        var total = 0;
        for (var _i = 0, _a = this.acervo; _i < _a.length; _i++) {
            var livro = _a[_i];
            total += livro.emEstoque;
        }
        return total;
    };
    AcervoComponent.prototype.adicionarUmNoCarrinho = function (livro) {
        console.log("quantidade" + livro.quantidade);
        console.log("estoque" + livro.emEstoque);
        if (livro.quantidade < livro.emEstoque) {
            livro.quantidade++;
            livro.emEstoque--;
        }
        console.log("quantidade" + livro.quantidade);
        console.log("estoque" + livro.emEstoque);
    };
    AcervoComponent = __decorate([
        core_1.Component({
            selector: 'acervo',
            templateUrl: 'app/acervo.component.html',
        }), 
        __metadata('design:paramtypes', [livro_data_service_1.LivroDataService])
    ], AcervoComponent);
    return AcervoComponent;
}());
exports.AcervoComponent = AcervoComponent;
//# sourceMappingURL=acervo.component.js.map