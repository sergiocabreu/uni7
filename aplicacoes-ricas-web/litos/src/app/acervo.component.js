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
        this.acervo = [];
    }
    AcervoComponent.prototype.ngOnInit = function () {
        this.getLivros();
    };
    AcervoComponent.prototype.getLivros = function () {
        var _this = this;
        this.livroDataService.getLivros()
            .then(function (livros) { _this.acervo = livros; })
            .catch(function (error) { return _this.errorMessage = error; });
    };
    /*getLivros(): void {
      this.livroDataService.getLivros()
      .subscribe(
          livros => this.acervo = livros,
          error => this.errorMessage = <any> error
      );
    }*/
    AcervoComponent.prototype.totalDeLivros = function () {
        var total = 0;
        for (var _i = 0, _a = this.acervo; _i < _a.length; _i++) {
            var livro = _a[_i];
            total += livro.emEstoque;
        }
        return total;
    };
    AcervoComponent.prototype.adicionarUmNoCarrinho = function (livro) {
        if (livro.quantidade < livro.emEstoque) {
            livro.quantidade++;
            livro.emEstoque--;
        }
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