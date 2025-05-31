import { useEffect, useState } from "react";
import { getOne } from "../../api/todoApi";

function ReadComponent({ tno }: { tno: number }) {
  const [todo, setTodo] = useState<Todo | undefined>(); //아직 todo는 사용하지 않음

  useEffect(() => {
    getOne(tno).then((data) => {
      console.log(data);
      setTodo(data);
    });
  }, [tno]);

  return (
    <>
      {todo && (
        <>
          <div className="border-2 border-sky-200 mt-10 m-2 p-4 text-2xl">
            {makeDiv("Tno", todo.tno)}
            {makeDiv("Writer", todo.writer)}
            {makeDiv("Title", todo.title)}
            {makeDiv("Title", todo.complete ? "Completed" : "Not Yet")}
          </div>
        </>
      )}
    </>
  );
}

const makeDiv = (title: string, value: string | number) => (
  <div className="flex justify-center">
    <div className="relative mb-4 flex w-full flex-wrap items-stretch">
      <div className="w-1/5 p-6 text-right font-bold">{title}</div>
      <div className="w-4/5 p-6 rounded-r border border-solid shadow-md">
        {value}
      </div>
    </div>
  </div>
);
export default ReadComponent;
