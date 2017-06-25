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
var task_service_1 = require('./task.service');
var TaskBoardComponent = (function () {
    function TaskBoardComponent(taskService) {
        this.taskService = taskService;
        this.tasks = [];
    }
    TaskBoardComponent.prototype.ngOnInit = function () {
        this.getLivros();
    };
    TaskBoardComponent.prototype.getLivros = function () {
        var _this = this;
        this.taskService.getLivros()
            .then(function (tasks) { _this.tasks = tasks; })
            .catch(function (error) { return _this.errorMessage = error; });
    };
    /*getLivros(): void {
      this.livroDataService.getLivros()
      .subscribe(
          livros => this.acervo = livros,
          error => this.errorMessage = <any> error
      );
    }*/
    TaskBoardComponent.prototype.totalDeLivros = function () {
        var total = 0;
        /*for (let livro of this.acervo){
          total += livro.emEstoque;
        }*/
        return total;
    };
    TaskBoardComponent.prototype.adicionarUmNoCarrinho = function (livro) {
        /*if (livro.quantidade < livro.emEstoque) {
            livro.quantidade++;
            livro.emEstoque--;
        }*/
    };
    TaskBoardComponent = __decorate([
        core_1.Component({
            selector: 'taskboard',
            templateUrl: 'app/taskboard.component.html',
        }), 
        __metadata('design:paramtypes', [task_service_1.TaskService])
    ], TaskBoardComponent);
    return TaskBoardComponent;
}());
exports.TaskBoardComponent = TaskBoardComponent;
//# sourceMappingURL=taskboard.component.js.map