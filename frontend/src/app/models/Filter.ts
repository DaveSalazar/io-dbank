export class Filter {

    readonly value: string;
    readonly field: string;
    readonly operator: string;

    constructor(field: string, operator: string, value: string) {
        this.value = value;
        this.field = field;
        this.operator = operator;
    }

   
    public static encodeFilters(filters: Filter[]): string {
        let filterQuery = filters.map((el, index) => {
          let field = encodeURIComponent(`filters[${index}][field]`) + `=${el.field}`;
          let value = encodeURIComponent(`filters[${index}][value]`) + `=${el.value}`;
          let operator = encodeURIComponent(`filters[${index}][operator]`) + `=${el.operator}`;
          return `${field}&${value}&${operator}`;
        }).join('&');
        return filterQuery;
      }
}
