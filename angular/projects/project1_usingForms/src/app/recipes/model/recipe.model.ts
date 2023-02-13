import { Ingredient } from "src/app/shared/Ingredient.model";

export class Recipe{
    constructor(public name:string,public description:string,public imageUrl:string
        ,public ingredients:Ingredient[]){

    }
}