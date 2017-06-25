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
var platform_browser_1 = require('@angular/platform-browser');
var platform_browser_dynamic_1 = require('@angular/platform-browser-dynamic');
var app_component_1 = require('./app/app.component');
var taskboard_component_1 = require('./app/taskboard.component');
var forms_1 = require('@angular/forms');
var task_service_1 = require('./app/task.service');
var router_1 = require('@angular/router');
var tarefa_component_1 = require('./app/tarefa.component');
var http_1 = require('@angular/http');
var task_component_1 = require('./app/task.component');
var appRoutes = [
    { path: '', redirectTo: 'taskboard', pathMatch: 'full' },
    { path: 'taskboard', component: taskboard_component_1.TaskBoardComponent },
    { path: 'tarefas/:id', component: tarefa_component_1.TarefaComponent }
];
var AppModule = (function () {
    function AppModule() {
    }
    AppModule = __decorate([
        core_1.NgModule({
            imports: [platform_browser_1.BrowserModule, forms_1.FormsModule, http_1.HttpModule, router_1.RouterModule.forRoot(appRoutes)],
            declarations: [app_component_1.AppComponent, tarefa_component_1.TarefaComponent, task_component_1.TaskComponent, taskboard_component_1.TaskBoardComponent],
            bootstrap: [app_component_1.AppComponent],
            providers: [task_service_1.TaskService]
        }), 
        __metadata('design:paramtypes', [])
    ], AppModule);
    return AppModule;
}());
platform_browser_dynamic_1.platformBrowserDynamic().bootstrapModule(AppModule);
//# sourceMappingURL=main.js.map