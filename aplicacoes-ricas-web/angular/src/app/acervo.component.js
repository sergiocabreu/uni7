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
var AcervoComponent = (function () {
    function AcervoComponent() {
        this.titulo = 'Livraria Lito';
        this.acervo = [
            {
                "id": 1,
                "titulo": "O Senhor dos Anéis",
                "descricao": "Contos da Terra Média",
                "preco": 100,
                "emEstoque": 10
            },
            {
                "id": 2,
                "titulo": "Livro dos Sith",
                "descricao": "A Ascensão do Livro dos Sith",
                "preco": 100,
                "emEstoque": 20
            }
        ];
    }
    AcervoComponent.prototype.totalDeLivros = function () {
        var total = 0;
        for (var _i = 0, _a = this.acervo; _i < _a.length; _i++) {
            var livro = _a[_i];
            total += livro.emEstoque;
        }
        return total;
    };
    AcervoComponent = __decorate([
        core_1.Component({
            selector: 'acervo',
            template: "\n    <ul>\n        <li *ngFor=\"let livro of acervo\">\n            <h2>{{livro.titulo}}</h2>\n            <h3>{{livro.descricao | uppercase}}</h3>\n            <p>{{livro.preco | currency: 'BRL': true}}</p>\n            <p *ngIf=\"livro.emEstoque > 0\">{{livro.emEstoque}} restantes</p>\n            <p *ngIf=\"livro.emEstoque === 0\">ESGOTADO</p>             \n        </li>\n    </ul>\n    <p>Total de exemplares: {{totalDeLivros()}}</p> \n"
        }), 
        __metadata('design:paramtypes', [])
    ], AcervoComponent);
    return AcervoComponent;
}());
exports.AcervoComponent = AcervoComponent;
//# sourceMappingURL=acervo.component.js.map